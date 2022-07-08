package org.outshoes.outshoesserver;

public class Producto {
	private int idProducto;
	private String skuProducto;
	private String nombreProducto;
	private String descripcionProducto;
	private int marcaProducto;
	private int colorProducto;
	private int tallaProducto;
	private int cantidadProducto;
	private int categoriaProducto;
	private int coleccionProducto;
	private int precioProducto;
	private String imagenProducto;
	private static int total = 0;
	
	public Producto(int idProducto, String skuProducto, String nombreProducto, String descripcionProducto,
			int marcaProducto, int colorProducto, int tallaProducto, int cantidadProducto, int categoriaProducto,
			int coleccionProducto, int precioProducto, String imagenProducto) {
		super();
		this.idProducto = idProducto;
		this.skuProducto = skuProducto;
		this.nombreProducto = nombreProducto;
		this.descripcionProducto = descripcionProducto;
		this.marcaProducto = marcaProducto;
		this.colorProducto = colorProducto;
		this.tallaProducto = tallaProducto;
		this.cantidadProducto = cantidadProducto;
		this.categoriaProducto = categoriaProducto;
		this.coleccionProducto = coleccionProducto;
		this.precioProducto = precioProducto;
		this.imagenProducto = imagenProducto;
		total++;
		this.idProducto = total;
	}

	public Producto () {
		/* Ya no es necesario cuando se conecte con la base de datos*/ 
		total++;
		this.idProducto = total;
	}
	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getSkuProducto() {
		return skuProducto;
	}

	public void setSkuProducto(String skuProducto) {
		this.skuProducto = skuProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public int getMarcaProducto() {
		return marcaProducto;
	}

	public void setMarcaProducto(int marcaProducto) {
		this.marcaProducto = marcaProducto;
	}

	public int getColorProducto() {
		return colorProducto;
	}

	public void setColorProducto(int colorProducto) {
		this.colorProducto = colorProducto;
	}

	public int getTallaProducto() {
		return tallaProducto;
	}

	public void setTallaProducto(int tallaProducto) {
		this.tallaProducto = tallaProducto;
	}

	public int getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public int getCategoriaProducto() {
		return categoriaProducto;
	}

	public void setCategoriaProducto(int categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	public int getColeccionProducto() {
		return coleccionProducto;
	}

	public void setColeccionProducto(int coleccionProducto) {
		this.coleccionProducto = coleccionProducto;
	}

	public int getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(int precioProducto) {
		this.precioProducto = precioProducto;
	}

	public String getImagenProducto() {
		return imagenProducto;
	}

	public void setImagenProducto(String imagenProducto) {
		this.imagenProducto = imagenProducto;
	}

	
	
}
