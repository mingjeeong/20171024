package work.exception;

public class AuthenticationException extends Exception {
	public AuthenticationException() {
		super("사용자 인증 오류");
	}
}
