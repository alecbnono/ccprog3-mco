package model;

/**
 * The {@code ChocolateSyrup} class represents a chocolate-flavored syrup
 * used as an add-on in the coffee truck system.
 * <p>
 * It extends the {@link AddOn} class and specifies the type and unit
 * of measurement for chocolate syrup.
 * </p>
 *
 * This class is typically used as a binable item that can be restocked
 * and consumed during coffee preparation.
 *
 * @author
 */
public class ChocolateSyrup extends AddOn {

    /**
     * Constructs a {@code ChocolateSyrup} object with an initial amount of 0.
     */
    public ChocolateSyrup() {
        super();
    }

    /**
     * Constructs a {@code ChocolateSyrup} object with a specified initial amount.
     * If the amount exceeds the maximum allowed, it is capped at {@code MAX_AMOUNT}.
     *
     * @param amount the initial quantity of chocolate syrup
     */
    public ChocolateSyrup(double amount) {
        super(amount);
    }

    /**
     * Returns the type of this add-on, which is "Chocolate".
     *
     * @return the type as a {@code String}
     */
    @Override
    public String getType() {
        return "Chocolate";
    }

    /**
     * Returns the unit of measurement for this add-on, which is fluid ounces.
     *
     * @return the unit as a {@code String} ("fl. oz.")
     */
    @Override
    public String getUnit() {
        return "fl. oz.";
    }
}
