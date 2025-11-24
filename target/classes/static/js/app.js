document.addEventListener('DOMContentLoaded', () => {
    fetchProducts();

    const searchInput = document.getElementById('search-input');
    searchInput.addEventListener('input', (e) => {
        const query = e.target.value.toLowerCase();
        filterProducts(query);
    });
});

let allProducts = [];

async function fetchProducts() {
    try {
        const response = await fetch('/api/products');
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        allProducts = await response.json();
        renderProducts(allProducts);
    } catch (error) {
        console.error('Error fetching products:', error);
        document.getElementById('product-list').innerHTML = '<p>Error cargando productos. Por favor intente más tarde.</p>';
    }
}

function renderProducts(products) {
    const productList = document.getElementById('product-list');
    productList.innerHTML = '';

    products.forEach(product => {
        const card = document.createElement('div');
        card.className = 'product-card';
        
        // Format price to currency
        const price = new Intl.NumberFormat('es-AR', { style: 'currency', currency: 'ARS' }).format(product.precio);
        
        // Placeholder image logic if url is generic
        const imageUrl = product.imagenUrl.startsWith('http') ? product.imagenUrl : 'https://http2.mlstatic.com/D_NQ_NP_964136-MLA45653558664_042021-O.webp'; // Generic placeholder

        card.innerHTML = `
            <div class="card-image-container">
                <img src="${imageUrl}" alt="${product.nombre}" class="card-image">
            </div>
            <div class="card-content">
                <div class="product-price">${price}</div>
                <div class="product-installments">en 12x ${(product.precio / 12).toFixed(2)}</div>
                <div class="product-shipping">Envío gratis</div>
                <h3 class="product-title">${product.nombre}</h3>
            </div>
        `;
        
        productList.appendChild(card);
    });
}

function filterProducts(query) {
    const filtered = allProducts.filter(product => 
        product.nombre.toLowerCase().includes(query) || 
        product.categoria.toLowerCase().includes(query)
    );
    renderProducts(filtered);
}
