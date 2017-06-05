package pl.cyfronet.engine.component;

import com.agreemount.slaneg.action.DocumentFactory;
import org.springframework.stereotype.Service;
import pl.cyfronet.bazaar.engine.extension.bean.IndigoDocument;

/**
 * Created by mszostak on 12.04.17.
 */

@Service(value = "DocumentFactory")
public class IndigoDocumentFactory extends DocumentFactory<IndigoDocument> {
    public IndigoDocumentFactory() {
        super(IndigoDocument.class);
    }

    @Override
    public IndigoDocument createInstance() {
        return new IndigoDocument();
    }
}
