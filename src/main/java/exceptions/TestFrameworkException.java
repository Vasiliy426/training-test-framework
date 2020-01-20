package exceptions;

public class TestFrameworkException extends RuntimeException {

        public TestFrameworkException() {
            super();
        }

        public TestFrameworkException(String message) {
            super(message);
        }

        public TestFrameworkException(String message, Throwable cause) {
            super(message, cause);
        }

        public TestFrameworkException(Throwable cause) {
            super(cause);
        }

}
