package pl.cyfronet.indigo.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

/**
 * @author bwilk
 *
 */
@Entity
@Data
@IdClass(DocumentWeightPk.class)
public class DocumentWeight {

    @Id
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ManyToOne
    @JsonIgnore
    private User user;

    @Id
    private String document;

    private Integer weight;

}
