<template>
  <div>
    <h1>{{ msg }}</h1>
    <h2>{{ $route.params.id }}</h2>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'this is user'
    }
  },
  watch: {
    '$route' (to, from) {
      console.log(from)
      console.log(to)
    }
  }
}
</script>
<style scoped>
h1, h2 {
  font-weight: normal;
}
</style>
