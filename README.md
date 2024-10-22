

# L-Clearlag

The plugin completely resolves the entity lag of versions 1.14/1.15/1.16/1.17/1.18!

Has no method been able to solve entity lag so far?
Use this plugin!

### How does it works?
Minecraft tracks a lot of entities, even if they are outside the tracking range of the player, that's a normal behavior but is a tps killer for 1.14.4 to 1.19 servers with more than 30 players. So what this plugin do is untrack those entities every configured ticks and track them again if the player is near.

```yaml
####################################################################################################
#                                                                                                  #
#                                       __          ___    _     __                                #
#                          |      ───  /  `  |     |__    /_\   |__)                               #
#                          |___        \__,  |___  |___  /   \  |  \                               #
#                                                                                                  #
#                                                         _    __                                  #
#                                                  |     /_\  / _                                  #
#                                                  |___ /   \ \__/                                 #
#                                                                                                  #
#                                                                                                  #
#                                                                                                  #
#                                                                                                  #
#                                       nykoxyz                                                    #
#                            Complete lag resolution in servers!                                   #
#                                  [ 1.14.4    -    1.19 ]                                         #
#                                                                                                  #
#                                                                                                  #
#                                                                                                  #
####################################################################################################

# Should we notify the console when we interact with entities?
# - Default value(s): false
log-to-console: false


# Should we disable tick operations of un-tracked entities?
# Note 1: this option only works for +1.16.1 servers
# - Default value(s): true
disable-tick-for-untracked-entities: true


# How low should the server's TPS be before we do anything?
# - Note: Setting this value above 20 will skip this check, allowing the tasks to run 24/7.
# - Default value(s): 20.0
tps-limit: 20.0


# What entities should we ignore?
# - Default value(s):
#   - creeper
#   - villager
#   - ender_dragon
#   - armor_stand
ignore-entity-list:
  - creeper
  - villager
  - ender_dragon
  - armor_stand

# Should we ignore an entity with a name?
# - Default value(s): true
ignore-entity-name: true


# How far (in blocks) should we look for players near un-tracked entities?
# - Default value(s): 50
tracking-range: 50


# How often (in ticks) should we check for "lingering" entities?
# - Default value(s): 1000
untrack-ticks: 1000


# Should the plugin perform tasks on all worlds?
# Note: if this is set to true, the option "worlds" will be ignored
# - Default value(s): true
enable-on-all-worlds: true


# What worlds should we perform our tasks on?
# - Default value(s):
#   - world
#   - world_nether
#   - world_the_end
worlds:
  - world
  - world_nether
  - world_the_end

# Do you use a system to limit the number of entities per chunk?
# - Default value(s): false
chunk-entity-limit-enable: false

# Limits the number of entities per chunk.
# - Precaution: If set to pig:10, only 10 animals will be spawn per bundle.
# - Note : Set to all:10 and you can have up to 10 entities per chunk.
# Default value(s):
#  - all:70
entity-limit:
  - all:70



# Beta version
# villager-enable: false
# - Default value(s): 600
ticks-per-allow-search: 600



version: 1.7.1
```

nykoxyz


#minecraft entity lag fix

Report any bug in the discussion section.
