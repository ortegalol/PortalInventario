let dataTable;
let dataTableIsInitialized = false;
const dataTableOptions = {
    scrollX: true,
    lengthMenu: [5, 10, 15, 20, 100, 200, 500],
    columnDefs: [
        {className: "centered", targets: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43]},
        {orderable: false, targets: [44, 45]},
        {searchable: false, targets: [44, 45]},
        {width: "10%", targets: []}
    ],
    pageLength: 10,
    destroy: true,
    language: {
        lengthMenu: "Mostrar _MENU_ registros por página",
        zeroRecords: "Ningún registro encontrado",
        info: "Mostrando de _START_ a _END_ de un total de _TOTAL_ registros",
        infoEmpty: "Ningún registro encontrado",
        infoFiltered: "(filtrados desde _MAX_ registros totales)",
        search: "Buscar:",
        loadingRecords: "Cargando...",
        paginate: {
            first: "Primero",
            last: "Último",
            next: "Siguiente",
            previous: "Anterior"
        }
    },
    colReorder: true // Activamos la funcionalidad de reordenar columnas
};
const initDataTable = async () => {
    if (dataTableIsInitialized) {
        dataTable.destroy();
    }

    dataTable = $("#datatable_asing").DataTable(dataTableOptions);
    dataTableIsInitialized = true;
};
$(document).ready(function () {
    initDataTable();

    // Escuchador para el evento search.dt
    $('#datatable_asing').on('search.dt', function () {
        // Si el valor del buscador es diferente de vacío, muestra el botón
        if ($('#datatable_asing').DataTable().search() !== "") {
            $("#btnDescargar").show();
        } else {
            // De lo contrario, oculta el botón
            $("#btnDescargar").hide();
        }
    });
});

function descargarXLSX() {
    let filteredData = dataTable.rows({filter: 'applied'}).data();
    let dataToExport = [];

    for (let i = 0; i < filteredData.length; i++) {
        dataToExport.push(filteredData[i]);
    }

    let ws = XLSX.utils.json_to_sheet(dataToExport);
    let wb = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, "Datos Filtrados");

    XLSX.writeFile(wb, "datos_filtrados.xlsx");
}

// Vincular el evento click del botón con la función de descarga
$("#btnDescargar").on("click", descargarXLSX);

