package org.itsimulator.germes.app.infra.exception.flow;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.itsimulator.germes.app.infra.exception.FlowException;

/**
 * {@link ValidationException} is raised when attribute values of the object
 * model violates business rules or restrictions
 * 
 * @author Morenets
 *
 */
public class ValidationException extends FlowException {
	private static final long serialVersionUID = 6858621613562789296L;

	/**
	 * List of constaints message keys
	 */
	private final Set<ConstraintViolation<?>> constraints;

	public ValidationException(String message, Set<ConstraintViolation<?>> constraints) {
		super(message + constraints);
		this.constraints = constraints;
	}

	public Set<ConstraintViolation<?>> getConstraints() {
		return constraints;
	}
	
}
