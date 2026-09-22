// Mobile Menu Toggle
const hamburger = document.querySelector('.hamburger');
const navMenu = document.querySelector('.nav-menu');

if (hamburger) {
    hamburger.addEventListener('click', () => {
        navMenu.classList.toggle('active');
    });
}

// Close menu when a link is clicked
const navLinks = document.querySelectorAll('.nav-menu a');
navLinks.forEach(link => {
    link.addEventListener('click', () => {
        navMenu.classList.remove('active');
    });
});

// Smooth scrolling for anchor links
document.querySelectorAll('a[href^="#"]').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const target = document.querySelector(this.getAttribute('href'));
        if (target) {
            target.scrollIntoView({
                behavior: 'smooth',
                block: 'start'
            });
        }
    });
});

// News Grid - Filter functionality (optional enhancement)
const newsCards = document.querySelectorAll('.news-card');
if (newsCards.length > 0) {
    // Add hover effects or dynamic filtering here
    newsCards.forEach(card => {
        card.addEventListener('mouseenter', () => {
            card.style.transform = 'scale(1.02)';
        });
        card.addEventListener('mouseleave', () => {
            card.style.transform = 'scale(1)';
        });
    });
}

// Myth Teaser - Interactive reveal
const mythCards = document.querySelectorAll('.myth-card');
mythCards.forEach(card => {
    card.addEventListener('click', () => {
        card.classList.toggle('revealed');
    });
});

// Resource Links - Track clicks (optional analytics)
const resourceLinks = document.querySelectorAll('.resource-card a');
resourceLinks.forEach(link => {
    link.addEventListener('click', (e) => {
        console.log('Resource clicked:', link.textContent);
        // You could send this to analytics here
    });
});

// Scroll animations - Fade in elements as you scroll
const observerOptions = {
    threshold: 0.1,
    rootMargin: '0px 0px -100px 0px'
};

const observer = new IntersectionObserver((entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            entry.target.classList.add('fade-in');
            observer.unobserve(entry.target);
        }
    });
}, observerOptions);

// Apply observer to sections and cards
document.querySelectorAll('.news-card, .freedom-card, .resource-card').forEach(element => {
    observer.observe(element);
});

// Form submission (if you have a newsletter signup or contact form)
const contactForm = document.querySelector('form');
if (contactForm) {
    contactForm.addEventListener('submit', (e) => {
        e.preventDefault();
        // Handle form submission here
        console.log('Form submitted');
        // Example: Show success message
        alert('Thank you for your submission!');
        contactForm.reset();
    });
}

// Active Navigation Highlighting
window.addEventListener('scroll', () => {
    let current = '';
    
    const sections = document.querySelectorAll('section');
    sections.forEach(section => {
        const sectionTop = section.offsetTop;
        if (scrollY >= sectionTop - 200) {
            current = section.getAttribute('id');
        }
    });

    navLinks.forEach(link => {
        link.classList.remove('active');
        if (link.getAttribute('href').slice(1) === current) {
            link.classList.add('active');
        }
    });
});

// Fade-in animation class (add to your CSS)
// .fade-in { animation: fadeIn 0.6s ease-in; }
// @keyframes fadeIn { from { opacity: 0; } to { opacity: 1; } }
