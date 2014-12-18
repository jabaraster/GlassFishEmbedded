/**
 * 
 */
package info.jabara.sandbox.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author jabaraster
 */
@Entity
@ToString
@NoArgsConstructor
public class EEmployee implements Serializable {
    private static final long serialVersionUID = -5034416374843934729L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    Long                      id;

    @Column(nullable = false, length = 100)
    @Setter
    @Getter
    @NotNull
    String                    name;

    /**
     * @param pName -
     */
    public EEmployee(final String pName) {
        this.setName(pName);
    }
}
