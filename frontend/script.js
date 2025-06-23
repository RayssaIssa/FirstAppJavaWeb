const API = "http://localhost:8080";

function mostrarMensagem(id, texto, sucesso = true) {
    const el = document.getElementById(id);
    el.textContent = texto;
    el.className = "mensagem " + (sucesso ? "sucesso" : "erro");
}

async function adicionarAluno() {
    const aluno = {
        nome: document.getElementById("nomeAluno").value.trim(),
        email: document.getElementById("emailAluno").value.trim(),
        matricula: document.getElementById("matriculaAluno").value.trim(),
        curso: document.getElementById("cursoAluno").value.trim()
    };
    if (!aluno.nome || !aluno.email || !aluno.matricula || !aluno.curso) {
        mostrarMensagem("mensagemAluno", "Por favor, preencha todos os campos.", false);
        return;
    }
    try {
        const resp = await fetch(`${API}/alunos`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(aluno)
        });
        if (resp.ok) {
            mostrarMensagem("mensagemAluno", "Aluno adicionado com sucesso!");
        } else {
            mostrarMensagem("mensagemAluno", "Erro ao adicionar aluno.", false);
        }
    } catch {
        mostrarMensagem("mensagemAluno", "Erro de conexão com servidor.", false);
    }
}

async function listarAlunos() {
    const tabela = document.getElementById("tabelaAlunos");
    const corpo = tabela.querySelector("tbody");
    corpo.innerHTML = "";
    try {
        const resp = await fetch(`${API}/alunos`);
        const alunos = await resp.json();
        if (alunos.length > 0) {
            alunos.forEach(a => {
                corpo.innerHTML += `
                    <tr>
                        <td>${a.id}</td>
                        <td>${a.nome}</td>
                        <td>${a.email}</td>
                        <td>${a.matricula}</td>
                        <td>${a.curso}</td>
                        <td><button class="btn-remove" onclick="removerAluno(${a.id})">Remover</button></td>
                    </tr>`;
            });
            tabela.classList.add("visivel");
        } else {
            mostrarMensagem("mensagemAluno", "Nenhum aluno encontrado.", false);
            tabela.classList.remove("visivel");
        }
    } catch {
        mostrarMensagem("mensagemAluno", "Erro ao listar alunos.", false);
        tabela.classList.remove("visivel");
    }
}

async function removerAluno(id) {
    if (!confirm("Deseja remover este aluno?")) return;
    try {
        const resp = await fetch(`${API}/alunos/${id}`, { method: "DELETE" });
        if (resp.ok) {
            listarAlunos();
        } else {
            alert("Erro ao remover aluno.");
        }
    } catch {
        alert("Erro de conexão.");
    }
}

async function adicionarDisciplina() {
    const disciplina = {
        nome: document.getElementById("nomeDisciplina").value.trim(),
        carga_horaria: document.getElementById("cargaHorariaDisciplina").value.trim()
    };
    if (!disciplina.nome || !disciplina.carga_horaria) {
        mostrarMensagem("mensagemDisciplina", "Por favor, preencha todos os campos.", false);
        return;
    }
    try {
        const resp = await fetch(`${API}/disciplinas`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(disciplina)
        });
        if (resp.ok) {
            mostrarMensagem("mensagemDisciplina", "Disciplina adicionada com sucesso!");
        } else {
            mostrarMensagem("mensagemDisciplina", "Erro ao adicionar disciplina.", false);
        }
    } catch {
        mostrarMensagem("mensagemDisciplina", "Erro de conexão com servidor.", false);
    }
}

async function listarDisciplinas() {
    const tabela = document.getElementById("tabelaDisciplinas");
    const corpo = tabela.querySelector("tbody");
    corpo.innerHTML = "";
    try {
        const resp = await fetch(`${API}/disciplinas`);
        const disciplinas = await resp.json();
        if (disciplinas.length > 0) {
            disciplinas.forEach(d => {
                corpo.innerHTML += `
                    <tr>
                        <td>${d.id}</td>
                        <td>${d.nome}</td>
                        <td>${d.carga_horaria}</td>
                        <td><button class="btn-remove" onclick="removerDisciplina(${d.id})">Remover</button></td>
                    </tr>`;
            });
            tabela.classList.add("visivel");
        } else {
            mostrarMensagem("mensagemDisciplina", "Nenhuma disciplina encontrada.", false);
            tabela.classList.remove("visivel");
        }
    } catch {
        mostrarMensagem("mensagemDisciplina", "Erro ao listar disciplinas.", false);
        tabela.classList.remove("visivel");
    }
}

async function removerDisciplina(id) {
    if (!confirm("Deseja remover esta disciplina?")) return;
    try {
        const resp = await fetch(`${API}/disciplinas/${id}`, { method: "DELETE" });
        if (resp.ok) {
            listarDisciplinas();
        } else {
            alert("Erro ao remover disciplina.");
        }
    } catch {
        alert("Erro de conexão.");
    }
}
