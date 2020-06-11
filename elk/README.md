#Estrutura ELK
Elastic, Kibana, Logstash

Aumentar quantidade de arquivos que podem ser carregados em memória
sysctl -w vm.max_map_count=262144

versão utilizada:
todos os serviços devem seguir a mesma versão
ELK_VERSION=7.6.2

referencia das configurações https://github.com/deviantony/docker-elk

popular logs para exemplo:

# Using BSD netcat (Debian, Ubuntu, MacOS system, ...)

$ cat /path/to/logfile.log | nc -q0 localhost 5000

# Using GNU netcat (CentOS, Fedora, MacOS Homebrew, ...)

$ cat /path/to/logfile.log | nc -c localhost 5000

How to disable paid features

Switch the value of Elasticsearch's xpack.license.self_generated.type option from trial to basic (see License settings).https://www.elastic.co/guide/en/elasticsearch/reference/current/license-settings.html

How to scale out the Elasticsearch cluster

Follow the instructions from the Wiki: Scaling out Elasticsearch
https://github.com/deviantony/docker-elk/wiki/Elasticsearch-cluster