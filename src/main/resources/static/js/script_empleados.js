let dataTable;
let dataTableIsInitialized = false;
const dataTableOptions = {
    scrollX: true,
    lengthMenu: [5, 10, 15, 20, 100, 200, 500],
    columnDefs: [
        {className: "centered", targets: [0, 1, 2, 3, 4, 5, 6, 7, 8]},
        {orderable: false, targets: [9, 10]},
        {searchable: false, targets: [9, 10]},
        {width: "10%", targets: [1, 3, 4, 5, 6, 7]}
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

    }

};
const initDataTable = async () => {
    if (dataTableIsInitialized) {
        dataTable.destroy();
    }

    dataTable = $("#datatable_users").DataTable(dataTableOptions);
    dataTableIsInitialized = true;
};
$(document).ready(function () {
    initDataTable();
});