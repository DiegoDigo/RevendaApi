@ECHO OFF
IF %1.==. No1


GOTO deploy


:No1
  ECHO Digite a versao.

:deploy
    ECHO gerando build.
    call mvn clean install -DskipTests=true
    ECHO criando imagem.
    call docker build -t digodiego/api-revenda:%1 .
    call docker build -t digodiego/api-revenda:latest .
    ECHO Upload da imagem para o dockerhub.
    call docker login -u digodiego -p @mesma1012
    call docker push digodiego/api-revenda:%1
    call docker push digodiego/api-revenda:latest