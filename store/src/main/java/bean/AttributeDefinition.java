package bean;

import lombok.Data;

@Data
public class AttributeDefinition extends BaseEntity {

	private String name;
	private String type;
	private boolean required;
	private boolean searchable;
	private boolean sortable;
	private boolean facetable;

}
