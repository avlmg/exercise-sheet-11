package de.unistuttgart.iste.sqa.pse.sheet11.presence.spacehamsters;

/**
 * Functional interface for special abilities of space hamsters.
 */
@FunctionalInterface
public interface SpecialAbility {
	/**
	 * Applies a hamster's special ability to the given spaceship.
	 *
	 * @param ship the ship to apply the special ability to
	 */
	public void applySpecialAbility(final SpaceShip ship);
}