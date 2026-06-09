import {
  app,
  HttpHandler,
  HttpRequest,
  HttpResponse,
  InvocationContext,
} from "@azure/functions";
import * as df from "durable-functions";
import {
  ActivityHandler,
  OrchestrationContext,
  OrchestrationHandler,
} from "durable-functions";

const activityName = "durableHello";

export const durableHelloOrchestrator: OrchestrationHandler = function* (
  context: OrchestrationContext,
) {
  const outputs = [];
  outputs.push(yield context.df.callActivity(activityName, "Tokyo")); //executes the activity
  outputs.push(yield context.df.callActivity(activityName, "Seattle"));
  outputs.push(yield context.df.callActivity(activityName, "Cairo"));

  return outputs;
};
//register the orchestrator
df.app.orchestration("durableHelloOrchestrator", durableHelloOrchestrator);

const durableHello: ActivityHandler = (input: string): string => {
  //The DFM will show output against each step if that step returns something
  return `Hello, ${input}`;
};
//register the activity with the name
df.app.activity(activityName, { handler: durableHello });

// http trigger
const durableHelloHttpStart: HttpHandler = async (
  request: HttpRequest,
  context: InvocationContext,
): Promise<HttpResponse> => {
  //returns a promise
  const client = df.getClient(context);
  const body: unknown = await request.text();
  const instanceId: string = await client.startNew(
    request.params.orchestratorName,
    { input: body },
  ); //starts the orchestration

  context.log(`Started orchestration with ID = '${instanceId}'.`);

  return client.createCheckStatusResponse(request, instanceId);
};

// takes the trigger name
app.http("durableHelloHttpStart", {
  route: "orchestrators/{orchestratorName}",
  extraInputs: [df.input.durableClient()],
  handler: durableHelloHttpStart, //takes the http trigger
});
