 function removeMovie(id) {
       fetch(`/movies/api/remove/${id}`, { method: 'DELETE' })
           .then(response => response.text())
   .then(message => {
       location.reload();
       alert(message);
   })
   .catch(error => {
       console.error("Erro ao remover o filme:", error);
   });
   }

   function showInputField(button) {
   const noteSection = button.nextElementSibling; // Obtém a seção da nota próxima ao botão
   noteSection.style.display = noteSection.style.display === 'none' ? 'block' : 'none'; // Alterna a exibição
}

function saveNote(button) {
   const noteInput = button.previousElementSibling; // Localiza a caixa de texto associada
   const note = noteInput.value.trim();
   const movieId = button.getAttribute('data-movie-id'); // Obtém o ID do filme

   if (note && movieId) {
       fetch(`/movies/api/addReview`, {
           method: 'POST',
           headers: {
               'Content-Type': 'application/json'
           },
           body: JSON.stringify({ movieId: parseInt(movieId), review: note })
       })
       .then(response => {
           if (response.ok) {
               location.reload();
               alert('Nota salva com sucesso!');
               noteInput.value = ''; // Limpa o campo de texto
           } else {
               throw new Error('Erro ao salvar a nota.');
           }
       })
       .catch(error => console.error('Erro:', error));
   } else {
       alert('Por favor, insira uma nota válida.');
   }
}

function saveMovie(idExterno) {
        fetch(`/movies/api/save/${idExterno}`, { method: 'GET' })
            .then(response => response.text())
    .then(message => {
        alert(message);
    })
    .catch(error => {
        console.error("Erro ao salvar o filme:", error);
    });
    }