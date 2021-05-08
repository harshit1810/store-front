export class AttributeDefinition {
    id: number;
    name: string;
    type: string;
    required: boolean;
    searchable: boolean;
    sortable: boolean;
    facetable: boolean;

    constructor(
        id: number,
        name: string,
        type: string,
        required: boolean,
        searchable: boolean,
        sortable: boolean,
        facetable: boolean
    ) {
        Object.assign(this, {
            id,
            name,
            type,
            required: required === true,
            searchable: searchable === true,
            sortable: sortable === true,
            facetable: facetable === true
        });
    }
}