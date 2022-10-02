package se.lexicon.myjpaassignmentspringdata.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;

@Entity
@Table(name = "recipe_instruction")
public class RecipeInstruction {

    @Id
    @Column(name = "instruction_id")
    private int id;

    private String instruction;


    public RecipeInstruction() {
    }

    public RecipeInstruction(int id, String instruction) {
        this.id = id;
        this.instruction = instruction;
    }





    public RecipeInstruction(String instruction) {
        this.instruction = instruction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeInstruction that = (RecipeInstruction) o;
        return id == that.id && Objects.equals(instruction, that.instruction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instruction);
    }

    @Override
    public String toString() {
        return "RecipeInstruction{" +
                "id=" + id +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
