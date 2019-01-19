package section10;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * java-study
 * section10
 * Created by kukuxiahuni on 2018/6/3.
 */
public class Insurance {
    private String name;

    public String getName() {
        return name;
    }


    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car) {

        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    public Insurance findCheapestInsurance(Person person, Car car) {

        OptionalInt.empty();
        return null;
    }
}
