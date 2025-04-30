async function cadastrarAluno(event) {
    event.preventDefault(); //evita o envio tradicional do form

    //cria objeto pra ser enviado (nesse caso um aluno)
    let formData = {
        nome: document.getElementById("nomeAluno").value,
        cpf: document.getElementById("cpfAluno").value
    };

    console.log(formData);
    try {
        let response = await fetch("http://localhost:8080/aluno", { //url da requisição / mesma url que bota no postman
        method: "POST", //metodo da requisição
            headers: { "Content-Type": "application/json"}, //informa que um json esta sendo enviado !!!!
            //converte obj em json
            body: JSON.stringify(formData) //conteudo que esta sendo enviado, neste caso é um JSON
    });

    if(!response.ok) { //se der erro no back
        alert("Erro do back-end" + response.status)
        return
    }

    let data = await response.json() //converte o JSON que tá no body pra um obj js

    //aí se der certo a requisição, isto que vai ser retornado (daqui pra baixo)

    alert("Sucesso: " + JSON.stringify(data));
    // carregarAlunos();
} catch (error) {
    alert("Erro na requisição: " + error.message)
}
}

async function carregarAlunos() {
    try {
        let response = await fetch("http://localhost:8080/aluno", {
            method: "GET",
            headers: { "Content-Type": "application/json"},
        });

        if (!response.ok) {
            alert("Erro do back-end" + response.status)
            return
        }

        let data = await response.json()

        let lista = document.getElementById("listaAlunos");
        lista.innerHTML = ""; //Limpa a lista antes de add
        data.forEach(produto => {
            let aluno = document.createElement("li");
            aluno.textContent = `ID: ${aluno.id} - Nome: ${aluno.nome} - Cpf: ${aluno.cpf}`;
            let btnDeletar = document.createElement("button")
            btnDeletar.textContent = "Deletar";
            btnDeletar.style.marginLeft = "10px";
            btnDeletar.onclick = function() {
                deletarAluno(aluno.id)
            }
            aluno.appendChild(btnDeletar);
            lista.appendChild(aluno)
        });
    } catch (error) {
        alert("Error na requisição " + error.message)
    }
}

//funçao pra deletar o aluno
async function deletarAluno(id) {
    if (confirm("Voce tem certeza disso??")) {
        try {
            let response = await fetch(`http://localhost:8080/aluno/${id}`, {
            method: "DELETE",
            headers: {"Content-Type": "application/json"},
        });

        if (!response.ok){
            alert("Erro do back end " + response.status)
            return
        }

        alert("Aluno deletado com sucesso! 🔫🗡️🗡️")
        carregarAlunos();
        } catch (error) {
            alert("Error na requisição: " + error.message)
        }
    }
}


document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("alunoForm").addEventListener("submit", cadastrarAluno);
    document.getElementById("carregarAlunos").addEventListener("click", carregarAlunos);
});
