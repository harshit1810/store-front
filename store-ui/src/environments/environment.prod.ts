const apiBaseUrl = 'https://ecommstoreproducts-stage.herokuapp.com/api';
export const environment = {
  production: true,
  apiUrl: {
    productSearch: apiBaseUrl + '/v1/product-search/',
    products: apiBaseUrl + '/v1/products/',
    category: apiBaseUrl + '/v1/categories/',
    customer: apiBaseUrl + '/v1/customers/'
  }
};
