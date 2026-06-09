import { OrchestrationContext, Task } from "durable-functions";
import { durableHelloOrchestrator } from "../functions/durableHelloOrch";
import { when } from "jest-when";

describe("Test durableHelloOrch", () => {
  it("should test the orchestrator", () => {
    const mockContext: OrchestrationContext = {
      df: {
        callActivity: jest.fn() as jest.Mock,
        currentUtcDateTime: Date.now(),
      },
    } as unknown as OrchestrationContext;

    //The activity returns a task
    when(mockContext.df.callActivity)
      .calledWith("durableHello", "Tokyo")
      .mockReturnValue({
        isCompleted: true,
        isFaulted: false,
        result: "Hello Tokyo",
      } as Task);
    when(mockContext.df.callActivity)
      .calledWith("durableHello", "Seattle")
      .mockReturnValue({
        isCompleted: true,
        isFaulted: false,
        result: "Hello Seattle",
      } as Task);
    when(mockContext.df.callActivity)
      .calledWith("durableHello", "Cairo")
      .mockReturnValue({
        isCompleted: true,
        isFaulted: false,
        result: "Hello Cairo",
      } as Task);

    const generator = durableHelloOrchestrator(mockContext);

    let result = generator.next();
    const cities: string[] = ["Hello Tokyo", "Hello Seattle", "Hello Cairo"];
    let i = 0;

    while (!result.done) {
      result = generator.next(cities[i]);
      i++;
    }

    expect(result.value).toEqual([
      "Hello Tokyo",
      "Hello Seattle",
      "Hello Cairo",
    ]);
    console.log((mockContext.df.callActivity as jest.Mock).mock.calls);
  });
});
