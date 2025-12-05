document.addEventListener("DOMContentLoaded", function() {
    // Animações ao rolar para as seções
    const sections = document.querySelectorAll("section");

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add("fade-in");
            }
        });
    }, {
        threshold: 0.5
    });

    sections.forEach(section => {
        observer.observe(section);
    });

    // Feedback ao enviar formulário
    const form = document.querySelector("form");
    form.addEventListener("submit", function(e) {
        e.preventDefault();
        const name = form.querySelector('input[type="text"]').value;
        const email = form.querySelector('input[type="email"]').value;
        const message = form.querySelector('textarea').value;

        if (name && email && message) {
            // Exibe um feedback de sucesso de forma mais estilizada
            Swal.fire({
                icon: 'success',
                title: 'Mensagem Enviada!',
                text: `Obrigado, ${name}! Sua mensagem foi enviada com sucesso. Nossa equipe responderá em breve.`,
                confirmButtonText: 'Fechar'
            });
            form.reset();
        } else {
            // Validação para mostrar o alerta de erro
            Swal.fire({
                icon: 'error',
                title: 'Erro!',
                text: 'Por favor, preencha todos os campos.',
                confirmButtonText: 'Fechar'
            });
        }
    });

    // Suaviza o efeito de rolagem para as âncoras
    const navLinks = document.querySelectorAll(".navbar a");
    navLinks.forEach(link => {
        link.addEventListener("click", (event) => {
            event.preventDefault();
            const targetId = link.getAttribute("href").substring(1);
            const targetElement = document.getElementById(targetId);
            window.scrollTo({
                top: targetElement.offsetTop - 50,
                behavior: "smooth"
            });
        });
    });
});
