package net.vfalkenberg.examples.crud.exception;

import javax.persistence.PersistenceException;

public class UnknownPersistenseException extends UserFriendlyException {
    public UnknownPersistenseException(PersistenceException cause){
        super(cause, "exception.persistence.unknown");

    }
}
