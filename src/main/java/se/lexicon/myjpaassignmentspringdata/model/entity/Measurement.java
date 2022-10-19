package se.lexicon.myjpaassignmentspringdata.model.entity;

public enum Measurement {

    TBSP("Tablespoon"), TSP("Teaspoon"), G("Gram"), HG("Hektogram"), KG("Kilogram"), ML("Milliliter"), CL("Centiliter"), DL("Deciliter");

    private String measurementText;


    Measurement(String measurementText) {
        this.measurementText = measurementText;
    }

    public String getMeasurementText() {
        return measurementText;
    }

    public void setMeasurementText(String measurementText) {
        this.measurementText = measurementText;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "measurementText='" + measurementText + '\'' +
                '}';
    }
}
