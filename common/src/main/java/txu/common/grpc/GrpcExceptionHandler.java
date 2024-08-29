package txu.common.grpc;

import io.grpc.*;
import lombok.extern.slf4j.Slf4j;
import txu.common.exception.NotFoundException;
//import txu.shop.exception.NotFoundException;
//import txu.movie.exception.NotFoundException;

@Slf4j
public class GrpcExceptionHandler implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata, ServerCallHandler<ReqT, RespT> serverCallHandler) {
        ServerCall.Listener<ReqT> listener = serverCallHandler.startCall(serverCall, metadata);
        return new GrpcExceptionHandlingServerCallListener<>(listener, serverCall, metadata);
    }
    private static class GrpcExceptionHandlingServerCallListener<ReqT, RespT>extends ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT> {
        private final ServerCall<ReqT, RespT> serverCall;
        private final Metadata metadata;

        GrpcExceptionHandlingServerCallListener(ServerCall.Listener<ReqT> listener,
                                                ServerCall<ReqT, RespT> serverCall,
                                                Metadata metadata) {
            super(listener);
            this.serverCall = serverCall;
            this.metadata = metadata;
        }

        @Override
        public void onHalfClose() {
            try {
                super.onHalfClose();
            } catch (RuntimeException ex) {
                handleException(ex, serverCall, metadata);
            }
        }

        @Override
        public void onReady() {
            try {
                super.onReady();
            } catch (RuntimeException ex) {
                handleException(ex, serverCall, metadata);
            }
        }

        private void handleException(
                RuntimeException ex, ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
            Status status = translateStatus(ex);
            serverCall.close(status.withDescription(ex.getMessage()), metadata);
        }

        static Status translateStatus(Throwable ex) {

//            if (ex instanceof BadParameterException ||
//                    ex instanceof IllegalArgumentException) {
//                return Status.INVALID_ARGUMENT;
//            }

            if (ex instanceof NotFoundException) {
                return Status.NOT_FOUND;
            }

//            if (ex instanceof ConflictException) {
//                return Status.ALREADY_EXISTS;
//            }

            if (ex instanceof UnsupportedOperationException) {
                return Status.UNIMPLEMENTED;
            }

            log.error("{} handled by exception handler: {}",
                    ex.getClass().getSimpleName(), ex.getMessage(), ex);
            return Status.INTERNAL;
        }
    }
}
