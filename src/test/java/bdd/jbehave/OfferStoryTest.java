package bdd.jbehave;

import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class OfferStoryTest extends JUnitStoryBase {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new OfferCreationSteps());
    }

}
