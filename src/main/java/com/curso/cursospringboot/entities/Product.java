package com.curso.cursospringboot.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String descricao;

	private Double price;

	private String imgUrl;

	@ManyToMany
	@JoinTable(name = "tb_product_categories", joinColumns = @JoinColumn(name = "fk_produto_id"), inverseJoinColumns = @JoinColumn(name = "fk_category_id"))
	private Set<Category> categories = new HashSet<>();

	@OneToMany(mappedBy = "id.product") // product tem um id do tipo OrderItemPK e LA POSSUI o produto na chave
	private Set<OrderItem> itens = new HashSet<>(); // mapeando para que seja possivel chegar aos pedidos de cada
													// produto

	public Product() {

	}

	public Product(Long id, String name, String descricao, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.descricao = descricao;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Category> getCategory() {
		return categories;
	}

	@JsonIgnore
	public Set<Order> getOrders() {
		
		//percorde os itens que estao vinculados a esse produto
		// e captura os pedidos
		Set<Order> set = new HashSet<>();

		for (OrderItem item : itens) {
			set.add(item.getOrder());
		}
		return set;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
}
