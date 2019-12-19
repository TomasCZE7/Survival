package object;

import core.component.shape.CustomShape;

public interface ObjectToShow extends ObjectToRender {

    CustomShape getCustomShape();

    default CustomShape[] getAdditionalShapes(){
        return new CustomShape[]{};
    }

}
