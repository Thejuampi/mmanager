package com.tj.mmanager.base.view.generator;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.TableFieldFactory;
import com.vaadin.ui.TextField;

@org.springframework.stereotype.Component
@Scope("prototype")
public class TjDefaultFieldFactory implements FormFieldFactory,
		TableFieldFactory {

	private static final long serialVersionUID = 1864604634670679040L;

	private Map<Object,FormFieldFactory> formFieldFactories = new HashMap<Object, FormFieldFactory>();

	private Map<Object,TableFieldFactory> tableFieldFactories = new HashMap<Object, TableFieldFactory>();

	public TjDefaultFieldFactory() {
	}

	public void addFormFieldFactory(Object propertyId,
			FormFieldFactory fieldFactory) {
		formFieldFactories.put(propertyId, fieldFactory);
	}

	/** TODO creo que esto no esta completaente bien, REVISAR.
	 * 
	 * @param propertyId
	 * @param fieldFactory
	 */
	public void addTableFieldFactory(Object propertyId,
			TableFieldFactory fieldFactory) {
		tableFieldFactories.put(propertyId, fieldFactory);
	}

	@Override
	public Field createField(Container container, Object itemId,
			Object propertyId, Component uiContext) {
		
		TableFieldFactory tff = tableFieldFactories.get(itemId);
		if(tff != null){
			Field field = createField(container, itemId, propertyId, uiContext);
			field.setCaption(createCaptionByPropertyId(propertyId));
			return field;
		} else {
			Property containerProperty = container.getContainerProperty(itemId, propertyId);
			Class<?> type = containerProperty.getType();
	        Field field = createFieldByPropertyType(type);
	        field.setCaption(createCaptionByPropertyId(propertyId));
	        return field;	
		}
		
	}

	@Override
	public Field createField(Item item, Object propertyId, Component uiContext) {
		FormFieldFactory fff = formFieldFactories.get(propertyId);
		if(fff != null) {
			Field field = fff.createField(item, propertyId, uiContext);
			field.setCaption(createCaptionByPropertyId(propertyId));
			return field;
		} else {
			Class<?> type = item.getItemProperty(propertyId).getType();
			Field field = createFieldByPropertyType(type);
			field.setCaption(createCaptionByPropertyId(propertyId));
			return field;	
		}
	}

	public static String createCaptionByPropertyId(Object propertyId) {
		String name = propertyId.toString();
		if (name.length() > 0) {

			if (name.indexOf(' ') < 0
					&& name.charAt(0) == Character.toLowerCase(name.charAt(0))
					&& name.charAt(0) != Character.toUpperCase(name.charAt(0))) {
				StringBuffer out = new StringBuffer();
				out.append(Character.toUpperCase(name.charAt(0)));
				int i = 1;

				while (i < name.length()) {
					int j = i;
					for (; j < name.length(); j++) {
						char c = name.charAt(j);
						if (Character.toLowerCase(c) != c
								&& Character.toUpperCase(c) == c) {
							break;
						}
					}
					if (j == name.length()) {
						out.append(name.substring(i));
					} else {
						out.append(name.substring(i, j));
						out.append(" " + name.charAt(j));
					}
					i = j + 1;
				}

				name = out.toString();
			}
		}
		return name;
	}

	/**
	 * Creates fields based on the property type.
	 * <p>
	 * The default field type is {@link TextField}. Other field types generated
	 * by this method:
	 * <p>
	 * <b>Boolean</b>: {@link CheckBox}.<br/>
	 * <b>Date</b>: {@link DateField}(resolution: day).<br/>
	 * <b>Item</b>: {@link Form}. <br/>
	 * <b>default field type</b>: {@link TextField}.
	 * <p>
	 * 
	 * @param type
	 *            the type of the property
	 * @return the most suitable generic {@link Field} for given type
	 */
	public static Field createFieldByPropertyType(Class<?> type) {
		// Null typed properties can not be edited
		if (type == null) {
			return null;
		}

		// Item field
		if (Item.class.isAssignableFrom(type)) {
			return new Form();
		}

		// Date field
		if (Date.class.isAssignableFrom(type)) {
			final DateField df = new DateField();
			df.setResolution(DateField.RESOLUTION_DAY);
			return df;
		}

		// Boolean field
		if (Boolean.class.isAssignableFrom(type)) {
			return new CheckBox();
		}

		TextField textField = new TextField();
		textField.setNullRepresentation("");
		return textField;
	}
}
