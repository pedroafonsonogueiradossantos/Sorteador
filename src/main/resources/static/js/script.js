$(document).ready(function () {
        $("#botaoSortear").click(enviar);

        function enviar () {
            let quantidade = parseInt($("#qtd").val());
            let numeroMinimo = parseInt($("#min").val());
            let numeroMaximo = parseInt($("#max").val());
            let cbordenar = $("#cbordenar")[0].checked;
            let cbrepetir = $("#cbrepetir")[0].checked;

            if (!cbrepetir && quantidade > numeroMaximo) {
                alert("Falha na comunicação com o servidor");
            } else {
                $.ajax({
                       type: "POST",
                       url: "/result",
                       data: { 
					   quantidade: quantidade,
                       numeroMinimo: numeroMinimo,
                       numeroMaximo: numeroMaximo,
                       cbordenar: cbordenar,
                       cbrepetir: cbrepetir,
                       },
                        success: function (data) {
                             $("html").html(data);
                             $("#botaoSortear").click(enviar);
                             history.pushState(null, null, "/result");
                        },
                        error: function (data) {
                                alert("Falha na comunicação com o servidor");
                        }
                });
            }
        };
    });