package net.vfalkenberg.examples.crud.exception;

import lombok.Getter;

import static java.util.Objects.requireNonNull;

@Getter
public abstract class UserFriendlyException extends RuntimeException{

    private final String code;

    private final Object[]  args;

    public UserFriendlyException(String code, Object... args) {
        this.code = requireNonNull(code);
        this.args = args;
    }
    public UserFriendlyException(Throwable cause, String code, Object... args) {
        super(cause);
        this.code = requireNonNull(code);
        this.args = args;
    }
}
