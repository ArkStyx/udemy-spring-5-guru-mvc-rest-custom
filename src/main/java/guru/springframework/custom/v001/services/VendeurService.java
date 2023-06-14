package guru.springframework.custom.v001.services;

public interface VendeurService {

	GET /vendors/						Lists all the vendors
	GET /vendors/{id}					Get a vendor by id
	
	POST /vendors/						Create a vendor
	DELETE /vendors/{id}				Delete a vendor
	PATCH /vendors/{id}					Update a vendor
	PUT /vendors/{id}					Replace a vendor by new data
	
	GET /vendors/{id}/products/			Get the products of a vendor
	POST /vendors/{id}/products/		Add a product to a vendor
	
}
