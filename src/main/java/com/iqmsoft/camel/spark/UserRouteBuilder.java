
package com.iqmsoft.camel.spark;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;


public class UserRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        
        restConfiguration().component("spark-rest").bindingMode(RestBindingMode.json).dataFormatProperty("prettyPrint", "true");

        
        rest("/user").consumes("application/json").produces("application/json")

            .get("/view/{id}").outType(User.class)
                .to("bean:userService?method=getUser(${header.id})")

            .get("/list").outTypeList(User.class)
                .to("bean:userService?method=listUsers")

            .put("/update").type(User.class).outType(User.class)
                .to("bean:userService?method=updateUser");
    }

}