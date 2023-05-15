<template>
  <div class="buscar" src="./assets/search3.png">
    Pesquisar
  </div>
</template>
<Buscar />
<HelloWorld />
<script>
  import Buscar from './components/Buscar.vue'
  import HelloWorld from './components/HelloWorld.vue';

export default {
  name: 'App',
  components: {
    Buscar, HelloWorld
  },
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.buscar{
    background-color:#2F4F4F;
    color: white;
    border:solid 1px;
    border-radius:15px;
    width:150px;
}
</style>