package pl.workshop.lib;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * CDI/JSF district converter for {@link District class}
 * 
 * @author JMa
 *
 */
@Named
@RequestScoped
public class DistrictConverter implements Converter {

	@Inject
	private LocationData locationData;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value != null) {
			for (District d : locationData.getDistricts()) {
				if (d.getId() == Integer.valueOf(value)) {
					return d;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object object) {
		if (object instanceof District) {
			return String.valueOf(((District) object).getId());
		}
		return "";
	}

}
