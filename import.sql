/*
-- CONSULTA QUE DEFINE AS INFORMAÇÕES PARA CONTROLE DE LOGIN JAAS
/*
--select * from pessoa where idPessoa = 1;

--SELECT Permissao.dsPermissao, 'Roles' FROM Pessoa, permissao_usuario, Permissao
--WHERE Pessoa.idPessoa = permissao_usuario.idPessoa
--AND Permissao.idPermissao =permissao_usuario.idPermissao and login = 'alcelio';
*/

drop database luznovale_banco;

create database luznovale_banco;

	
INSERT INTO `luznovale_banco`.`Sexo`
(`idSexo`,`dsSexo`)
VALUES
	('1', 'MASCULINO'),
    ('2', 'FEMENINO');

INSERT INTO `Permissao`(`idPermissao`,`dsDescricao`,`dsPermissao`) VALUES
(1,'Administrador','ROLE_ADMIN'),
(2,'Usuario','ROLE_USUARIO');


-- Date: 2017-02-24 20:13


INSERT INTO `Parametros` (`idParametro`,`desFuncaoParametro`,`desParametro`) VALUES (1,'Guardar valor da instituição padrão do sistema','PARAM_SYS_INSTIUICAO_PADRAO');


INSERT INTO `Funcao` (`idFuncao`,`desFuncao`) VALUES (1,'DIRETOR');
INSERT INTO `Funcao` (`idFuncao`,`desFuncao`) VALUES (12,'MONITOR');


-- Query: SELECT * FROM luznovale_banco.Pessoa

-- Date: 2017-02-24 20:08

INSERT INTO `Pessoa` (`DTYPE`,`idPessoa`,`desCNH`,`desCPF`,`desCPT`,`desEmail`,`desFone1`,`desFone2`,`desFone3`,`desNomeMae`,`desNomePai`,`desNomePessoa`,`desRG`,`dtaCadastro`,`dtaNascimento`,`outrosDocs`,`isAdminUser`,`isAtivo`,`isSuperUser`,`isUser`,`login`,`primeiroAcesso`,`senha`,`idEndereco`,`idFuncao`,`idSexo`) VALUES ('Usuario',1,'123456','027.208.299-22','234E','doalcelio@gmail.com','(51)99651-1789','','','','','ALCELIO GOMES','','2010-01-01','2010-01-01','',b'1',b'1',b'0',b'0','alcelio',b'0','alcelio',NULL,12,1);
INSERT INTO `Pessoa` (`DTYPE`,`idPessoa`,`desCNH`,`desCPF`,`desCPT`,`desEmail`,`desFone1`,`desFone2`,`desFone3`,`desNomeMae`,`desNomePai`,`desNomePessoa`,`desRG`,`dtaCadastro`,`dtaNascimento`,`outrosDocs`,`isAdminUser`,`isAtivo`,`isSuperUser`,`isUser`,`login`,`primeiroAcesso`,`senha`,`idEndereco`,`idFuncao`,`idSexo`) VALUES ('Interno',2,'123456','027.208.299-22','234E','doalcelio@gmail.com','(51) 99651-1789','','','','','ALCÉLIO GOMES','','2010-01-01','2010-01-01','',b'0',b'0',b'0',b'0','alcelio',b'0','alcelio',NULL,NULL,1);
INSERT INTO `Pessoa` (`DTYPE`,`idPessoa`,`desCNH`,`desCPF`,`desCPT`,`desEmail`,`desFone1`,`desFone2`,`desFone3`,`desNomeMae`,`desNomePai`,`desNomePessoa`,`desRG`,`dtaCadastro`,`dtaNascimento`,`outrosDocs`,`isAdminUser`,`isAtivo`,`isSuperUser`,`isUser`,`login`,`primeiroAcesso`,`senha`,`idEndereco`,`idFuncao`,`idSexo`) VALUES ('Interno',3,'123456','027.208.299-22','234E','doalcelio@gmail.com','51996511789','','','','','Paulada','','2010-01-01','2010-01-01','',b'0',b'0',b'0',b'0','alcelio',b'0','alcelio',NULL,NULL,1);
INSERT INTO `Pessoa` (`DTYPE`,`idPessoa`,`desCNH`,`desCPF`,`desCPT`,`desEmail`,`desFone1`,`desFone2`,`desFone3`,`desNomeMae`,`desNomePai`,`desNomePessoa`,`desRG`,`dtaCadastro`,`dtaNascimento`,`outrosDocs`,`isAdminUser`,`isAtivo`,`isSuperUser`,`isUser`,`login`,`primeiroAcesso`,`senha`,`idEndereco`,`idFuncao`,`idSexo`) VALUES ('Interno',4,'123456','027.208.299-22','234E','doalcelio@gmail.com','51996511789','','','','','Lima pereira','','2010-01-01','2010-01-01','',b'0',b'0',b'0',b'0','alcelio',b'0','alcelio',NULL,NULL,1);

/**UPDATES PÁRA VALORES ZERADOS*/
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCPT`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCPT`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCPT`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCPT`=b'0' WHERE `idPessoa`='4';     
/**CARTAO DO SUS*/
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCartaoSUS`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCartaoSUS`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCartaoSUS`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCartaoSUS`=b'0' WHERE `idPessoa`='4'; 
/** CARTEIRA DE VACINA */
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCarteiraVacina`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCarteiraVacina`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCarteiraVacina`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCarteiraVacina`=b'0' WHERE `idPessoa`='4';     
/**CERTIDÃO DE NASCIMENTO*/
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCertNascimento`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCertNascimento`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCertNascimento`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaCertNascimento`=b'0' WHERE `idPessoa`='4';        
/** LAUDO MEDICO */
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaLaudoMedico`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaLaudoMedico`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaLaudoMedico`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaLaudoMedico`=b'0' WHERE `idPessoa`='4';
/**PASSAPORTE*/
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaPassaporte`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaPassaporte`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaPassaporte`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaPassaporte`=b'0' WHERE `idPessoa`='4';    
/**RG*/
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaRG`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaRG`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaRG`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaRG`=b'0' WHERE `idPessoa`='4';
/**SEM DOCUMENTOS*/
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaSemDocumentos`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaSemDocumentos`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaSemDocumentos`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaSemDocumentos`=b'0' WHERE `idPessoa`='4';
/**TERCEIRA*/
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaTercerira`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaTercerira`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaTercerira`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `docEntradaTercerira`=b'0' WHERE `idPessoa`='4';
/**ESTEVE INTERNADO*/
UPDATE `luznovale_banco`.`Pessoa` SET `esteveInternado`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `esteveInternado`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `esteveInternado`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `esteveInternado`=b'0' WHERE `idPessoa`='4';
/**PROBLEMA JUSTIÇA*/
UPDATE `luznovale_banco`.`Pessoa` SET `problemaJustica`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `problemaJustica`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `problemaJustica`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `problemaJustica`=b'0' WHERE `idPessoa`='4';
/**PROBLEMA SAUDE*/
UPDATE `luznovale_banco`.`Pessoa` SET `problemaSaude`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `problemaSaude`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `problemaSaude`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `problemaSaude`=b'0' WHERE `idPessoa`='4';  
/**PROBLEMA TRABALHISTA*/
UPDATE `luznovale_banco`.`Pessoa` SET `problemaTrabalhista`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `problemaTrabalhista`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `problemaTrabalhista`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `problemaTrabalhista`=b'0' WHERE `idPessoa`='4';  
/**QUANDO TRABALHA*/    
UPDATE `luznovale_banco`.`Pessoa` SET `trabalhaNao`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `trabalhaNao`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `trabalhaNao`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `trabalhaNao`=b'0' WHERE `idPessoa`='4'; 
/**QUANDO NAO TRABALHA*/
UPDATE `luznovale_banco`.`Pessoa` SET `trabalhaSim`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `trabalhaSim`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `trabalhaSim`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `trabalhaSim`=b'0' WHERE `idPessoa`='4'; 
    
UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaBoa`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaBoa`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaBoa`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaBoa`=b'0' WHERE `idPessoa`='4';  

UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaMal`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaMal`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaMal`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaMal`=b'0' WHERE `idPessoa`='4';  

UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaOtima`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaOtima`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaOtima`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaOtima`=b'0' WHERE `idPessoa`='4';  

UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaRegular`=b'0' WHERE `idPessoa`='1';
UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaRegular`=b'0' WHERE `idPessoa`='2';
UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaRegular`=b'0' WHERE `idPessoa`='3';
UPDATE `luznovale_banco`.`Pessoa` SET `relacaoFamiliaRegular`=b'0' WHERE `idPessoa`='4';  





/*
* Insere as permissões para o usuaários
*/
INSERT INTO `permissao_usuario`(`idPessoa`,`idPermissao`)
VALUES
(1,1),
(1,2);

/*
--INSERE OS DADOS DA INSTITUICAO
-- Date: 2017-02-15 02:37
*/
INSERT INTO `Instituicao` (`idInstituicao`,`desEmail`,`desFOne2`,`desFone1`,`desNomeContato`,`desNomeInstituicao`,`desObs`,`idEndereco`) VALUES (1,'dilson@gmail.com','','(52) 99999-9999','DILSON GOMES','LUZ NO VALE','teste',NULL);

/*
-- Query: SELECT * FROM luznovale_banco.ParametrosSistema
LIMIT 0, 1000

-- Date: 2017-03-05 20:02
*/
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (1,'1','PARAM_SYS_INSTIUICAO_PADRAO','Guardar valor da instituição padrão do sistema');
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (2,'DILSON GOMES','PARAM_SYS_NOME_DIRETOR_FICHA','Nome do diretor que será colocado nas assinaturas impressas.');
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (3,'1','PARAM_SYS_IND_EXIBE_NOME_DIRETOR','Indica se deve exibir o nome do diretor nos formulário impresso (0- Não exibe, 1 - exibe)');
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (6,'120,00','PARAM_SYS_VALOR_MENSALIDADE','Guarda o valor das mensalidades básica que serão cobradas.');
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (7,'luznovale','PARAM_SYS_SENHA_PADRAO_NOVO_USUARIO','Guarda a senha dos que será cadastrada de forma automática para cada novo usuáriomou quando o mesmo solicitar o reset de sua senha.');
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (9,'FICHA DE INTERNAÇÃO','PARAM_SYS_TITULO_FICHA_INTERNACAO','Contém o título que será impresso na ficha de internação');
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (10,'ESTOU CIENTE PARA CUMPRIR E OBEDECER O REGULAMENTO DESTA INSTITUIÇÃO\r\nAO ASSINAR ESTE DOCUMENTO POR MINHA LIVRE E ESPONTÂNEA VONTADE.','PARAM_SYS_DECLARACAO_CIENCIA_INTERNACAO','Guarda o texto de declaração do interno, concordando com internação e as regras da instituição, que será impressp na finha de internação');
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (11,'Eu','PARAM_SYS_PESSOA_DECLARANTE','Guarda o texto qeu será impresso como pessoa declarante nos relatórios.');
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (12,'ao assinar esta declaração de pagamento da taxa de inscrição da internação do candidato estou ciente que não haverá devolução deste valor em hipótese alguma, independente do tempo que  o candidato permanecer internado.','PARAM_SYS_CIENCIA_PAGTO_TAXA','Gurda o texto que setá adicionado na ficha de internação como ciencia de pagamento e nao aceite de devolução de valores');
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (13,'1','PARAM_SYS_IND_EXIBE_OBS_DEV_TAXA','Indica se deve exibir no relatório a obeservação que não serão devolvidos valores pagos na taxa de inscrição. (0- Não, 1 - sim) Valor defult 1');
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (14,'OBS. A TAXA DE INSCRIÇÃO NÃO TEM DEVOLUÇÃO','PARAM_SYS_TEXTO_OBSERVACAO_TAXA_INSCRICAO','Guarda o texto qeu será impresso como observação de não devolução de valores.');
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (25,'Declaro para os devidos fins que o candidato abaixo citado está dando entrada a partir desta data na Instituição Evangélica Desafio Jovem Luz no Vale, para o tratamento de dependência química. \r\nSendo que o encaminhei e me responsabilizo pela sua internação.','PARAM_SYS_RESPONSAVEL_INTERNACAO','Guarda o texto onde a pessoa que efetuou a internação do candidato declara ciencia e responsabilidade perante a internação.');
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (26,'TERMO DE RESPONSABILIDADE PARA INTERNAÇÃO','PARAM_SYS_TITULO_TERMO_REPOSNSABILIDADE','Guarda o valor que será exibido como título da declaração de responsabilidade de internação na ficha de internação');
INSERT INTO `ParametrosSistema` (`idParametroSistema`,`desValorParametro`,`descricaoParametro`,`funcaoParametro`) VALUES (27,'ESTOU CIENTE PARA CUMPRIR E OBEDESER O REGULAMENTO DESTA INSTITUIÇÃO;\r\nAO ASSINAR ESTEDOCUMENTO, POR MINHA LIVRE E ESPONTÂNEA VONTADE.','PARAM_SYS_CIENCIA_REGULAMENTO','Guarda o texto onde interno declara estar ciente e seguir as regras da isntituição');



/*
*INSERE OS OBJETOS DOS INTERNOS
*/
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (50,'BÍBLIA');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (51,'BLUSA DE LÃ');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (52,'BLUSA MOLETOM');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (53,'BERMUDA');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (54,'BONÉ');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (55,'BOLSA');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (56,'CALÇA JEANS');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (57,'CALÇA TACTEL /  (ABRIGO)');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (58,'CAMISA SOCIAL');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (59,'CAMISA POLLO');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (60,'CAMISETA');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (61,'COBERTOR');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (62,'CUECA');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (63,'CASACO SOCIAL');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (64,'CASACO');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (65,'COLETE');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (66,'CINTO');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (67,'CHINELO');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (68,'FRONHA');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (69,'GRAVATA');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (70,'JAQUETA');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (71,'LENÇOL');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (72,'LENÇO');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (73,'LUVA');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (74,'MEIA');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (75,'MOCHILA');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (76,'SAPATO');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (77,'SAPATÊNIS');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (78,'SANDALHA');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (79,'TÊNIS');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (80,'TRAVESSEIRO');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (81,'TOALHA DE ROSTO');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (82,'TOALHA DE BANHO');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (83,'TERNO');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (84,'TOUCA');
INSERT INTO `Objeto` (`idObjeto`,`desObjeto`) VALUES (85,'PIJAMA');



