package com.tdnhat.bookstore.exception;

import javax.persistence.NoResultException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BookExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        if (e instanceof NoResultException) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        } else if (e instanceof IllegalArgumentException) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}

