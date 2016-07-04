package pl.workshop.lib;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CityConverter implements Converter {

	@Inject
	private LocationData locationData;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null) {
			for (City c : locationData.getCities()) {
				if (c.getId() == Integer.valueOf(value)) {
					return c;
				}
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		if (object instanceof City) {
			return String.valueOf(((City) object).getId());
		}
		return "";
	}

}
