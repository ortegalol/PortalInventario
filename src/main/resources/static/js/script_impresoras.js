let dataTable;
let dataTableIsInitialized = false;

const dataTableOptions = {
    scrollX: true,
    lengthMenu: [5, 10, 15, 20, 100, 200, 500],
    columnDefs: [
        {className: "centered", targets: [0, 1, 2, 3, 4, 5]},
        {orderable: false, targets: [6, 7]},
        {searchable: false, targets: [6, 7]},
        {width: "30%", targets: [0, 1, 2]}
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
    createdRow: function (row, data) {
        if (data[4] === 'true') {
            $('td', row).eq(4).css('background-color', 'green');
            $('td', row).eq(4).text('Asignado');
        } else {
            $('td', row).eq(4).css('background-color', 'red');
            $('td', row).eq(4).text('Sin Asignar');
        }
    }
};

const initDataTable = async () => {
    if (dataTableIsInitialized) {
        dataTable.destroy();
    }
    dataTable = $("#datatable_asing").DataTable(dataTableOptions);
    dataTableIsInitialized = true;
};

$(document).ready(function () {
    $.extend(true, $.fn.dataTable.defaults, dataTableOptions);
    initDataTable();
});