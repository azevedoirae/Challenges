CREATE TABLE produto(
   id INT AUTO_INCREMENT PRIMARY KEY
  ,nome VARCHAR(255) NOT NULL
  ,descricao VARCHAR(255)
  ,custoUnitario FLOAT
<<<<<<< HEAD
  ,fornecedor VARCHAR(255) NOT NULL
=======
  ,fornecedor VARCAR(255) NOT NULL
>>>>>>> 9e223b6ab8aed47a02d5f3ff96827a7c36a99c93
  ,codBarras VARCHAR(255) NOT NULL
  ,dataCadastro DATE NOT NULL DEFAULT CURRENT_TIMESTAMP );
