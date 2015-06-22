/*
 * Copyright (C) 2009-2015 Typesafe Inc. <http://www.typesafe.com>
 */

//#default
import play.http.HttpRequestHandler;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;

import java.lang.reflect.Method;

public class RequestHandler implements HttpRequestHandler {

    @Override
    public Action createAction(Http.Request request, Method actionMethod) {
        return new Action.Simple() {
            @Override
            public F.Promise<Result> call(Http.Context ctx) {
                return delegate.call(ctx);
            }
        };
    }

    @Override
    public Action wrapAction(Action action) {
        return action;
    }
}
//#default
