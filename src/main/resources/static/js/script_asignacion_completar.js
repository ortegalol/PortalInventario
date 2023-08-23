$(document).ready(function () {
    function handleSelectionChange(selector, endpoint, mappings) {
        $(selector).change(function () {
            const selectedValue = $(this).val();

            $.get(endpoint + selectedValue, function (data) {
                Object.keys(mappings).forEach(key => {
                    $(mappings[key]).val(data[key]);
                });
            });
        });
    }
    let empleadoSeleccionado = false;

    function toggleNextButton() {
        if (empleadoSeleccionado) {
            $('.next').prop('disabled', false);
        } else {
            $('.next').prop('disabled', true);
        }
    }

    $('#numEmpleadoInput').change(function () {
        empleadoSeleccionado = $(this).val() !== '';
        toggleNextButton();
    });

    $('.next').click(function () {
        if (!empleadoSeleccionado) {
            alert("Por favor selecciona un empleado antes de continuar.");
        }
    });

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



document.addEventListener('DOMContentLoaded', function () {
    let sections = ['empleado', 'cpu', 'monitor', 'teclado', 'raton', 'impresora', 'ups', 'scanner', 'pinpad', 'telefono'];
    let currentSection = 0;

    function updateDisplay() {
        sections.forEach(section => {
            document.getElementById(section).style.display = 'none';
        });
        document.getElementById(sections[currentSection]).style.display = 'block';
    }

    document.querySelectorAll('.next').forEach(btn => {
        btn.addEventListener('click', function () {
            if (currentSection < sections.length - 1) {
                currentSection++;
                updateDisplay();
            }
        });
    });

    document.querySelectorAll('.prev').forEach(btn => {
        btn.addEventListener('click', function () {
            if (currentSection > 0) {
                currentSection--;
                updateDisplay();
            }
        });
    });
});

document.getElementById("btn-guardar").addEventListener("click", function (event) {
    if (!confirm("¿Estás seguro de que deseas guardar los datos?")) {
        event.preventDefault(); // Evita que el formulario se envíe si el usuario cancela la confirmación
    }
});

document.getElementById("btn-guardar").addEventListener("click", function (event) {
    event.preventDefault(); // Evita que el formulario se envíe automáticamente

    // Recopila los valores de los campos del formulario
    var numEmpleado = document.getElementById("numEmpleadoInput").value;
    var idEmpleado = document.getElementById("idempleado").value;
    var nombre = document.getElementById("nombre").value;
    var email = document.getElementById("email").value;
    var rfc = document.getElementById("rfc").value;
    var curp = document.getElementById("curp").value;
    var departamento = document.getElementById("departamento").value;
    var puesto = document.getElementById("puesto").value;
    var seriePc = document.getElementById("seriePcInput").value;
    var idPc = document.getElementById("idpc").value;
    var marcaPc = document.getElementById("marcapc").value;
    var modeloPc = document.getElementById("modelopc").value;
    var procesadorPc = document.getElementById("procesador").value;
    var velocidadPc = document.getElementById("velocidad").value;
    var memoriaRamPc = document.getElementById("memoriaram").value;
    var almacenamientoPc = document.getElementById("almacenamiento").value;
    var origenPc = document.getElementById("origen").value;
    var estadoPc = document.getElementById("estado").value;
    var serieMonitor = document.getElementById("serieMoniInput").value;
    var idMonitor = document.getElementById("idmoni").value;
    var marcaMonitor = document.getElementById("marca").value;
    var modeloMonitor = document.getElementById("modelo").value;
    var serieTeclado = document.getElementById("serieTecladoInput").value;
    var idTeclado = document.getElementById("idteclado").value;
    var marcaTeclado = document.getElementById("marcateclado").value;
    var modeloTeclado = document.getElementById("modeloteclado").value;
    var serieRaton = document.getElementById("serieRatonInput").value;
    var idRaton = document.getElementById("idraton").value;
    var marcaRaton = document.getElementById("marcaraton").value;
    var modeloRaton = document.getElementById("modeloraton").value;
    var serieImpresora = document.getElementById("serieImpresoraInput").value;
    var idImpresora = document.getElementById("idimpresora").value;
    var marcaImpresora = document.getElementById("marcaimpresora").value;
    var modeloImpresora = document.getElementById("modeloimpresora").value;
    var tipoImpresora = document.getElementById("tipoimpresora").value;
    var serieUps = document.getElementById("serieUpsInput").value;
    var idUps = document.getElementById("idups").value;
    var marcaUps = document.getElementById("marcaups").value;
    var modeloUps = document.getElementById("modeloups").value;
    var serieScanner = document.getElementById("serieScannerInput").value;
    var idScanner = document.getElementById("idscanner").value;
    var marcaScanner = document.getElementById("marcascanner").value;
    var modeloScanner = document.getElementById("modeloscanner").value;
    var tipoScanner = document.getElementById("tiposcanner").value;
    var seriePinpad = document.getElementById("seriePinpadInput").value;
    var idPinpad = document.getElementById("idpinpad").value;
    var marcaPinpad = document.getElementById("marcapinpad").value;
    var modeloPinpad = document.getElementById("modelopinpad").value;
    var serieTelefono = document.getElementById("serieTelefonoInput").value;
    var idTelefono = document.getElementById("idtelefono").value;
    var marcaTelefono = document.getElementById("marcatelefono").value;
    var modeloTelefono = document.getElementById("modelotelefono").value;

    // Crea un mensaje de confirmación con los datos recopilados
    var confirmationMessage =
            "Por favor, verifica los datos antes de guardar:\n\n" +
            "Número de Empleado: " + numEmpleado + "\n" +
            "ID Empleado: " + idEmpleado + "\n" +
            "Nombre: " + nombre + "\n" +
            "Email: " + email + "\n" +
            "RFC: " + rfc + "\n" +
            "CURP: " + curp + "\n" +
            "Departamento: " + departamento + "\n" +
            "Puesto: " + puesto + "\n" +
            "Serie PC: " + seriePc + "\n" +
            "ID PC: " + idPc + "\n" +
            "Marca PC: " + marcaPc + "\n" +
            "Modelo PC: " + modeloPc + "\n" +
            "Procesador PC: " + procesadorPc + "\n" +
            "Velocidad PC: " + velocidadPc + "\n" +
            "Memoria RAM PC: " + memoriaRamPc + "\n" +
            "Almacenamiento PC: " + almacenamientoPc + "\n" +
            "Origen PC: " + origenPc + "\n" +
            "Estado PC: " + estadoPc + "\n" +
            "Serie Monitor: " + serieMonitor + "\n" +
            "ID Monitor: " + idMonitor + "\n" +
            "Marca Monitor: " + marcaMonitor + "\n" +
            "Modelo Monitor: " + modeloMonitor + "\n" +
            "Serie Teclado: " + serieTeclado + "\n" +
            "ID Teclado: " + idTeclado + "\n" +
            "Marca Teclado: " + marcaTeclado + "\n" +
            "Modelo Teclado: " + modeloTeclado + "\n" +
            "Serie Raton: " + serieRaton + "\n" +
            "ID Raton: " + idRaton + "\n" +
            "Marca Raton: " + marcaRaton + "\n" +
            "Modelo Raton: " + modeloRaton + "\n" +
            "Serie Impresora: " + serieImpresora + "\n" +
            "ID Impresora: " + idImpresora + "\n" +
            "Marca Impresora: " + marcaImpresora + "\n" +
            "Modelo Impresora: " + modeloImpresora + "\n" +
            "Tipo Impresora: " + tipoImpresora + "\n" +
            "Serie UPS: " + serieUps + "\n" +
            "ID UPS: " + idUps + "\n" +
            "Marca UPS: " + marcaUps + "\n" +
            "Modelo UPS: " + modeloUps + "\n" +
            "Serie Scanner: " + serieScanner + "\n" +
            "ID Scanner: " + idScanner + "\n" +
            "Marca Scanner: " + marcaScanner + "\n" +
            "Modelo Scanner: " + modeloScanner + "\n" +
            "Tipo Scanner: " + tipoScanner + "\n" +
            "Serie Pinpad: " + seriePinpad + "\n" +
            "ID Pinpad: " + idPinpad + "\n" +
            "Marca Pinpad: " + marcaPinpad + "\n" +
            "Modelo Pinpad: " + modeloPinpad + "\n" +
            "Serie Teléfono: " + serieTelefono + "\n" +
            "ID Teléfono: " + idTelefono + "\n" +
            "Marca Teléfono: " + marcaTelefono + "\n" +
            "Modelo Teléfono: " + modeloTelefono;

    // Muestra una ventana emergente con el mensaje de confirmación
    if (confirm(confirmationMessage)) {
        // Si el usuario confirma, envía el formulario
        document.getElementById("hardwareForm").submit();
    }
});
