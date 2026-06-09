import { InvocationContext } from "@azure/functions";
import { HttpHandler, HttpRequest, HttpResponse } from "@azure/functions/types/http";
import * as df from 'durable-functions';

const myGreetHttpTrigger:HttpHandler = async (request: HttpRequest, context: InvocationContext): Promise<HttpResponse> => { //returns a promise
    const client = df.getClient(context);

    const body: any = await request.json();
    context.log(`body for orchestrator: ${body.message}`)
    const instanceId: string = await client.startNew("durableMyGreetOrchestrator", { input: JSON.stringify(body) });//starts the orchestration

    context.log(`Started orchestration with ID = '${instanceId}'.`);

    return client.createCheckStatusResponse(request, instanceId);
};

export {myGreetHttpTrigger};