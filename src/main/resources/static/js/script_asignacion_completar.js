$(document).ready(function() {
    function handleSelectionChange(selector, endpoint, mappings) {
        $(selector).change(function() {
            const selectedValue = $(this).val();

            $.get(endpoint + selectedValue, function(data) {
                Object.keys(mappings).forEach(key => {
                    $(mappings[key]).val(data[key]);
                });
            });
        });
    }

    const configs = [
        {
            selector: "#numEmpleadoInput",
            endpoint: "/empleado/",
            mappings: {
                idempleado: "#idempleado",
                nombre: "#nombre",
                rfc: "#rfc",
                curp: "#curp",
                departamento: "#departamento",
                puesto: "#puesto",
                email: "#email"
            }
        },
        {
            selector: "#seriePcInput",
            endpoint: "/pc/",
            mappings: {
                idpc: "#idpc",
                marcapc: "#marcapc",
                modelopc: "#modelopc",
                procesador: "#procesador",
                velocidad: "#velocidad",
                memoriaram: "#memoriaram",
                almacenamiento: "#almacenamiento",
                origen: "#origen",
                estado: "#estado"
            }
        },
        {
            selector: "#serieMoniInput",
            endpoint: "/monitor/",
            mappings: {
                idmoni: "#idmoni",
                marca: "#marca",
                modelo: "#modelo",
                origen: "#origen",
                estado: "#estado"
            }
        },
        {
            selector: "#serieTecladoInput",
            endpoint: "/teclado/",
            mappings: {
                idteclado: "#idteclado",
                marcateclado: "#marcateclado",
                modeloteclado: "#modeloteclado"
            }
        },
        {
            selector: "#serieRatonInput",
            endpoint: "/raton/",
            mappings: {
                idraton: "#idraton",
                marcaraton: "#marcaraton",
                modeloraton: "#modeloraton"
            }
        },
        {
            selector: "#serieImpresoraInput",
            endpoint: "/impresora/",
            mappings: {
                idimpresora: "#idimpresora",
                marcaimpresora: "#marcaimpresora",
                modeloimpresora: "#modeloimpresora",
                tipoimpresora: "#tipoimpresora"
            }
        },
        {
            selector: "#serieUpsInput",
            endpoint: "/ups/",
            mappings: {
                idups: "#idups",
                marcaups: "#marcaups",
                modeloups: "#modeloups"
            }
        },
        {
            selector: "#serieScannerInput",
            endpoint: "/scanner/",
            mappings: {
                idscanner: "#idscanner",
                marcascanner: "#marcascanner",
                modeloscanner: "#modeloscanner",
                tiposcanner: "#tiposcanner"
            }
        },
        {
            selector: "#seriePinpadInput",
            endpoint: "/pinpad/",
            mappings: {
                idpinpad: "#idpinpad",
                marcapinpad: "#marcapinpad",
                modelopinpad: "#modelopinpad"
            }
        },
        {
            selector: "#serieTelefonoInput",
            endpoint: "/telefono/",
            mappings: {
                idtelefono: "#idtelefono",
                marcatelefono: "#marcatelefono",
                modelotelefono: "#modelotelefono"
            }
        }
    ];

    configs.forEach(config => {
        handleSelectionChange(config.selector, config.endpoint, config.mappings);
    });
});
