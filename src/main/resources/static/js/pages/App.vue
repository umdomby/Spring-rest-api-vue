<template>
    <div>
    <div v-if="!profile">Необходимо авторизоваться через
        <a href="/login">Google</a>
    </div>
    <div v-else>
        <div>{{profile.name}}&nbsp;<a href="/logout">Выйти</a></div>
    </div>
        <router-view></router-view>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                profile: frontendData.profile
            }
        },
      // beforeMount() {
      //   if (this.profile) {
      //     this.$router.replace('/message2')
      //   }
      // }
    }
</script>

<style>

</style>
