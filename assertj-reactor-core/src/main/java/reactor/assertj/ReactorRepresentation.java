package reactor.assertj;

import java.util.Map;

import org.assertj.core.presentation.StandardRepresentation;

import reactor.util.context.Context;

/**
 * Fixes representation of some problematic reactor classes.
 *
 * @author Simon Baslé
 */
public class ReactorRepresentation extends StandardRepresentation {

	@Override
	protected String fallbackToStringOf(Object object) {
		if (object instanceof Context && object instanceof Map.Entry) {
			Map.Entry entry = (Map.Entry) object;
			return entry.getKey() + "=" + entry.getValue();
		}

		return super.fallbackToStringOf(object);
	}
}
