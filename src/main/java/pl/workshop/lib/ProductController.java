package pl.workshop.lib;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class ProductController implements Serializable {

	private static final long serialVersionUID = -5753334735020095311L;

	private Product product;
	private List<Product> productList;

	@PostConstruct
	public void init() {
		productList = new ArrayList<>();
		productList.add(new Product(1, "AA", "Pendrive 16GB", new BigDecimal("32.40"), new Date()));
		productList.add(new Product(2, "BB", "S³uchawki", new BigDecimal("55.47"), new Date()));
		productList.add(new Product(3, "CC", "Pendrive 32GB", new BigDecimal("87.20"), new Date()));
		productList.add(new Product(4, "DD", "Pendrive 32GB", new BigDecimal("81.20"), new Date()));
		productList.add(new Product(5, "E6", "S³uchawki douszne", new BigDecimal("20.47"), new Date()));
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public void showGrowl() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("Sukces", "Doda³eœ produkt " + product.getName()));
	}

}
