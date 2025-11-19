class Pizza {
    constructor(nombre, precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    calcularPrecio(){
        return this.precio;
    }
}

class Margerita extends Pizza {
    constructor() {
        super('MARGHERITA', 9.30);
    }
}

class Prosciutto extends Pizza {
    constructor() {
        super('PROSCIUTTO', 12.00);
    }
}

class ProsciuttoFunghi extends Pizza {
    constructor() {
        super('PROSCIUTTO E FUNGHI', 12.50);
    }
}

class FourStagioni extends Pizza {
    constructor() {
        super('4 STAGIONI', 12.50);
    }
}

class Extras {
    constructor(nombreIngredienteExtra, precioIngredienteExtra) {
        this.nombreIngredienteExtra = nombreIngredienteExtra;
        this.precioIngredienteExtra = precioIngredienteExtra;
    }

    calcularPrecio(){
        return this.precioIngredienteExtra;
    }
}

class Basicos extends Extras{
    constructor(){
        super(['JAMÓN DULCE', 'EXTRA QUESO MOZZARELLA', 'TOMATE NATURAL', 'CHAMPIÑONES', 'ALCACHOFAS', 'ATÚN'], 0.90);
    }
}

class Gourmet extends Extras{
    constructor(){
        super(['OLIVAS', 'ALCAPARRAS', 'JAMÓN SERRANO', 'POLLO'], 1.20);
    }
}

class Premium extends Extras{
    constructor(){
        super(['ANCHOAS', 'SALMÓN', 'TERNERA PICADA'], 2.20);
    }
}

class SalsaBarbacoa extends Extras{
    constructor(){
        super(['SALSA BARBACOA'], 1.00);
    }
}

class SalsaPicante extends Extras{
    constructor(){
        super(['SALSA PICANTE'], 0.90);
    }
}

class BordeRelleno extends Extras{
    constructor(){
        super(['BORDE RELLENO DE QUESO'], 1.20);
    }
}


