// Função para navegar para a tela de avaliação
function goToEvaluation() {
    document.getElementById('screen-start').style.display = 'none';
    document.getElementById('screen-evaluation').style.display = 'block';
  }
  
  // Função para voltar à tela inicial
  function goToStart() {
    document.getElementById('screen-thank-you').style.display = 'none';
    document.getElementById('screen-start').style.display = 'block';
  }
  
  // Função para enviar a avaliação
  function submitEvaluation() {
    const medicalCare = document.getElementById('medical-care').value;
    const nursing = document.getElementById('nursing').value;
    const infrastructure = document.getElementById('infrastructure').value;
    const waitingTime = document.getElementById('waiting-time').value;
    const comments = document.getElementById('comments').value;
  
    console.log('Avaliação Enviada');
    console.log('Qualidade Médica:', medicalCare);
    console.log('Equipe de Enfermagem:', nursing);
    console.log('Infraestrutura:', infrastructure);
    console.log('Tempo de Espera:', waitingTime);
    console.log('Comentários:', comments);
  
    document.getElementById('screen-evaluation').style.display = 'none';
    document.getElementById('screen-thank-you').style.display = 'block';
  }
  
  // Atualizar os valores ao mover o slider
  document.getElementById('medical-care').addEventListener('input', function () {
    document.getElementById('medical-care-value').textContent = this.value;
  });
  
  document.getElementById('nursing').addEventListener('input', function () {
    document.getElementById('nursing-value').textContent = this.value;
  });
  
  document.getElementById('infrastructure').addEventListener('input', function () {
    document.getElementById('infrastructure-value').textContent = this.value;
  });
  
  document.getElementById('waiting-time').addEventListener('input', function () {
    document.getElementById('waiting-time-value').textContent = this.value;
  });
  